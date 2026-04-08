import React, { useState, useEffect } from 'react';
import { BrowserRouter as Router, Routes, Route, Link, useSearchParams } from 'react-router-dom';
import Login from './components/Login';
import Register from './components/Register';
import Foods from './components/Foods';
import Cart from './components/Cart';
import Orders from './components/Orders';
import Payment from './components/Payment';
import './App.css';

function App() {
  const [token, setToken] = useState(localStorage.getItem('token') || '');
  const [userId, setUserId] = useState(localStorage.getItem('userId') || '');
  const [cart, setCart] = useState([]);

  const addToCart = (food) => {
    setCart([...cart, food]);
  };

  const logout = () => {
    localStorage.removeItem('token');
    localStorage.removeItem('userId');
    setToken('');
    setUserId('');
    setCart([]);
  };

  return (
    <Router>
      <div className="App">
        <header className="header">
          <h1>🍜 Mini Food Ordering</h1>
        </header>
        <nav className="navbar">
          <span className="logo">🍜 FoodApp</span>
          <div className="nav-links">
            {!token ? (
              <>
                <Link to="/login">Đăng nhập</Link>
                <Link to="/register">Đăng ký</Link>
              </>
            ) : (
              <>
                <Link to="/foods">Món ăn</Link>
                <Link to="/cart">Giỏ hàng <span className="cart-badge">{cart.length}</span></Link>
                <Link to="/orders">Đơn hàng</Link>
                <button onClick={logout}>Đăng xuất</button>
              </>
            )}
          </div>
        </nav>
        <main className="container">
          <Routes>
            <Route path="/login" element={<Login setToken={setToken} setUserId={setUserId} />} />
            <Route path="/register" element={<Register setToken={setToken} setUserId={setUserId} />} />
            <Route path="/foods" element={<Foods addToCart={addToCart} />} />
            <Route path="/cart" element={<Cart cart={cart} setCart={setCart} userId={userId} />} />
            <Route path="/orders" element={<Orders userId={userId} />} />
            <Route path="/payment" element={<Payment />} />
            <Route path="/" element={<Foods addToCart={addToCart} />} />
          </Routes>
        </main>
      </div>
    </Router>
  );
}

export default App;

