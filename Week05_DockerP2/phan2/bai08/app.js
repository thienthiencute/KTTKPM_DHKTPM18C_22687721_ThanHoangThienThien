const express = require("express");
const mysql = require("mysql2");

const app = express();

const db = mysql.createConnection({
  host: "mysql_db",   // tên service trong docker-compose
  user: "user",
  password: "password",
  database: "mydb"
});

db.connect(err => {
  if (err) {
    console.error("❌ MySQL lỗi:", err);
  } else {
    console.log("✅ Kết nối MySQL thành công");
  }
});

app.get("/", (req, res) => {
  res.send("Hello Node + MySQL 🚀");
});

app.listen(3000, () => {
  console.log("🚀 Server chạy tại port 3000");
});