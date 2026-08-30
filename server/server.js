const express = require('express');
const WebSocket = require('ws');
const cors = require('cors');
const jwt = require('jsonwebtoken');
const http = require('http');

const app = express();
const server = http.createServer(app);
const wss = new WebSocket.Server({ server });

const PORT = process.env.PORT || 8080;
const SECRET = process.env.JWT_SECRET || 'roblox-2014-secret';

app.use(cors());
app.use(express.json());

// Armazenamento temporário de dados
const users = new Map();
const activeSessions = new Map();

// ===== API REST =====

// Registro de usuário
app.post('/api/register', (req, res) => {
    const { username, password, email } = req.body;

    if (users.has(username)) {
        return res.status(400).json({ error: 'Usuário já existe' });
    }

    const userData = {
        username,
        password: Buffer.from(password).toString('base64'), // Não usar em produção
        email,
        level: 1,
        createdAt: new Date()
    };

    users.set(username, userData);
    const token = jwt.sign({ username }, SECRET);

    res.json({ success: true, token, message: 'Usuário criado com sucesso' });
});

// Login
app.post('/api/login', (req, res) => {
    const { username, password } = req.body;
    const user = users.get(username);

    if (!user || Buffer.from(password).toString('base64') !== user.password) {
        return res.status(401).json({ error: 'Credenciais inválidas' });
    }

    const token = jwt.sign({ username }, SECRET);
    res.json({ success: true, token, user: { username: user.username, level: user.level } });
});

// Obter perfil
app.get('/api/profile/:username', (req, res) => {
    const user = users.get(req.params.username);

    if (!user) {
        return res.status(404).json({ error: 'Usuário não encontrado' });
    }

    res.json({
        username: user.username,
        level: user.level,
        email: user.email,
        avatar: 'https://via.placeholder.com/150',
        joinedAt: user.createdAt
    });
});

// Lista de servidores
app.get('/api/servers', (req, res) => {
    const servers = [
        { id: 1, name: 'Servidor Clássico 1', players: 45, maxPlayers: 100 },
        { id: 2, name: 'Servidor Clássico 2', players: 32, maxPlayers: 100 },
        { id: 3, name: 'Servidor PvP', players: 78, maxPlayers: 100 },
        { id: 4, name: 'Servidor Criativo', players: 12, maxPlayers: 50 }
    ];
    res.json(servers);
});

// Lista de games
app.get('/api/games', (req, res) => {
    const games = [
        { id: 1, title: 'Obby Clássico', plays: 5000, likes: 450 },
        { id: 2, title: 'Prison Life', plays: 8000, likes: 720 },
        { id: 3, title: 'Adopt Me!', plays: 10000, likes: 950 },
        { id: 4, title: 'Jailbreak', plays: 7500, likes: 680 }
    ];
    res.json(games);
});

// ===== WebSocket para Chat em Tempo Real =====

wss.on('connection', (ws) => {
    console.log('Cliente conectado ao chat');
    const clientId = Date.now();
    activeSessions.set(clientId, ws);

    ws.on('message', (data) => {
        const message = JSON.parse(data);
        const timestamp = new Date().toISOString();

        const broadcast = {
            userId: message.userId,
            username: message.username,
            content: message.content,
            timestamp
        };

        // Broadcast para todos os clientes conectados
        wss.clients.forEach(client => {
            if (client.readyState === WebSocket.OPEN) {
                client.send(JSON.stringify(broadcast));
            }
        });
    });

    ws.on('close', () => {
        activeSessions.delete(clientId);
        console.log('Cliente desconectado');
    });

    ws.on('error', (error) => {
        console.error('Erro WebSocket:', error);
    });
});

// ===== Iniciar Servidor =====

server.listen(PORT, () => {
    console.log(`🎮 Roblox 2014 Revival Server rodando em http://localhost:${PORT}`);
    console.log(`💬 WebSocket disponível em ws://localhost:${PORT}`);
});
