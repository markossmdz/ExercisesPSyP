const net = require("net");
const mysql = require("mysql2");

const db = mysql.createConnection({
    socketPath: "/var/run/mysqld/mysqld.sock", // Using Unix socket for MySQL
    user: "root",
    password: "rootpassword",
    database: "testdb"
});

// Create a TCP server
const server = net.createServer((socket) => {
    console.log("Client connected");

    socket.on("data", (data) => {
        console.log("Received:", data.toString());

        // Query the database and send results
        db.query('SELECT "Hello from MySQL" AS message', (err, result) => {
            if (err) {
                socket.write("Database error\n");
                return;
            }
            socket.write(`Database says: ${result[0].message}\n`);
        });
    });

    socket.on("end", () => console.log("Client disconnected"));
});

// Listen for TCP connections
server.listen(4000, () => console.log("Socket server listening on port 4000"));
