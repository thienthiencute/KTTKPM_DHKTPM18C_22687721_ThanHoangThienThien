const express = require("express");
const mongoose = require("mongoose");

const app = express();

mongoose.connect("mongodb://mongo:27017/test")
  .then(() => console.log("✅ MongoDB connected"))
  .catch(err => console.log("❌ Mongo error:", err));

app.get("/", (req, res) => {
  res.send("Hello Node + Mongo 🚀");
});

app.listen(3000, () => {
  console.log("🚀 Server chạy port 3000");
});