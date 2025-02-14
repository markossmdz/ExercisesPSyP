const net = require("net");

const client = require("net");
client.connect(4000, "backend", () => {
    console.log("Connected to backend");
    client.write("hello from client\n");
});

client.on("data", (data) => {
    console.log("Received:", data.toString());
    client.destroy();
});

client.on("close", () => console.log("Connection closed"));

