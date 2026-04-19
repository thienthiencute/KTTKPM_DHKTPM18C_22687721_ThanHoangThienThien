import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useLocation } from 'react-router-dom';

const Orders = ({ userId }) => {
  const [orders, setOrders] = useState([]);
  const [loading, setLoading] = useState(true);
  const location = useLocation();

  useEffect(() => {
    if (userId) {
      axios.get(`http://localhost:8083/api/orders?userId=${userId}`)
        .then(response => {
          setOrders(response.data);
          setLoading(false);
        })
        .catch(err => {
          console.error('Load orders failed', err);
          setLoading(false);
        });
    } else {
      setLoading(false);
    }
  }, [userId]);

  if (loading) return <div className="loading container"><h3>Đang tải đơn hàng...</h3></div>;

  return (
    <div className="container">
      <h2>Đơn hàng của bạn</h2>
      {orders.length === 0 ? (
        <div className="card">
          <p>Chưa có đơn hàng nào. <a href="/foods" style={{color: 'var(--primary)'}}>Đặt món ngay!</a></p>
        </div>
      ) : (
        orders.map(order => (
          <div key={order.id} className="card">
            <h4>Đơn hàng #{order.id}</h4>
            <p className={`status status-${order.status.toLowerCase()}`}>
              Trạng thái: {order.status}
            </p>
            <p className="price">Tổng: {order.total.toLocaleString()} VNĐ</p>
          </div>
        ))
      )}
    </div>
  );
};

export default Orders;

