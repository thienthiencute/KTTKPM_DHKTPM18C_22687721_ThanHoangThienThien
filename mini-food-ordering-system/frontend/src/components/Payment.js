import React, { useState, useEffect } from 'react';
import { useSearchParams, useNavigate } from 'react-router-dom';
import axios from 'axios';

const Payment = () => {
  const [searchParams] = useSearchParams();
  const orderId = searchParams.get('orderId');
  const [method, setMethod] = useState('COD');
  const [loading, setLoading] = useState(false);
  const navigate = useNavigate();

  const handlePayment = async () => {
    setLoading(true);
    try {
      await axios.post('http://localhost:8084/api/payments', {
        orderId: parseInt(orderId),
        method
      });
      alert('Thanh toán thành công! Kiểm tra Đơn hàng.');
      navigate('/orders');
    } catch (err) {
      alert('Thanh toán thất bại: ' + err.message);
    }
    setLoading(false);
  };

  return (
    <div className="container">
      <div className="card">
        <h2>Thanh toán đơn #{orderId}</h2>
        <div className="form-group">
          <label>Phương thức thanh toán</label>
          <select 
            className="form-control" 
            value={method} 
            onChange={(e) => setMethod(e.target.value)}
            style={{width: '100%', padding: '1rem', borderRadius: 'var(--border-radius)', border: '2px solid #e9ecef'}}
          >
            <option value="COD">COD (Thanh toán khi nhận hàng)</option>
            <option value="Banking">Chuyển khoản ngân hàng</option>
          </select>
        </div>
        <button className="btn btn-success" onClick={handlePayment} disabled={loading}>
          {loading ? 'Đang xử lý...' : 'Xác nhận thanh toán'}
        </button>
      </div>
    </div>
  );
};

export default Payment;

