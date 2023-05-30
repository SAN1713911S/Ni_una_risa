let stompClient;
let username;
let user;
let contUsuarios
let lastMessageSender = '';  // Variable para almacenar el último remitente

// Obtener el valor almacenado del contador al cargar la página
document.addEventListener('DOMContentLoaded', () => {
    contUsuarios = parseInt(localStorage.getItem('contUsuarios')) || 0;
    console.log('usuarios jugando', contUsuarios);
});

function connect(event) {
    username = document.querySelector('#username').value.trim();

    if (username && contUsuarios<2) {
        CrearEquipo(username);

        const login = document.querySelector('#login');
        login.classList.add('hide');

        const chatPage = document.querySelector('#chat-page');
        chatPage.classList.remove('hide');

        const socket = new SockJS('/chat-example');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, onConnected, onError);

        contUsuarios++;
        localStorage.setItem('contUsuarios', contUsuarios);
        console.log('usuarios jugando', contUsuarios);
    }else{
        alert("No se permiten mas jugadores en partida")
    }

    event.preventDefault();
}

function onConnected() {
    stompClient.subscribe('/topic/public', onMessageReceived);
    stompClient.send("/app/chat.newUser", {}, JSON.stringify({ sender: username, type: 'CONNECT' }));
}

function onError(error) {
    const status = document.querySelector('#status');
    status.innerHTML = 'Could not find the connection you were looking for. Move along. Or, Refresh the page!';
    status.style.color = 'red';
}

function sendMessage(event) {
    if (user != lastMessageSender) {
        if (stompClient) {
            const chatMessage = {
                sender: username,
                content: "CAMBIO",
                type: 'CHAT',
                time: moment().calendar()
            };
            stompClient.send("/app/chat.send", {}, JSON.stringify(chatMessage));
            user = username;
            console.log("mensajito ", user);

            const turnOff = document.querySelector('#chat-page');
            turnOff.classList.add('hide');

            const wait = document.querySelector('#wait');
            wait.classList.remove('hide');
        }
        event.preventDefault();
    } else {
        event.preventDefault();
    }
}

function onMessageReceived(payload) {
    const message = JSON.parse(payload.body);

    if (message.type === 'CONNECT') {
       console.log(message.sender + ' connected!');
    } else if (message.type === 'DISCONNECT') {
        contUsuarios--;
        localStorage.setItem('contUsuarios', contUsuarios);
        console.log(message.sender + ' left!');
    } else {
        console.log("mensaje de ", message.sender);
    }

    lastMessageSender = message.sender;
    if (user != lastMessageSender) {
        const turnOn = document.querySelector('#chat-page');
        turnOn.classList.remove('hide');
        const wait = document.querySelector('#wait');
        wait.classList.add('hide');
    }
}


