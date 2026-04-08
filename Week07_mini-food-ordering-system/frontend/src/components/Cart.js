import React from 'react';
import axios from 'axios';
import { useNavigate, Link } from 'react-router-dom';

const Cart = ({ cart, setCart, userId }) => {
  const navigate = useNavigate();
  const total = cart.reduce((sum, item) => sum + item.price, 0);

  const handleCheckout = async () => {
    if (!userId) {
      alert('Vui lòng đăng nhập trước');
      return;
    }

    try {
      const response = await axios.post('http://localhost:8083/api/orders', {
        userId: parseInt(userId),
        items: cart.map(item => ({
          foodId: item.id,
          quantity: 1,
          price: item.price
        }))
      });
      setCart([]);
      navigate('/payment?orderId=' + response.data.id);
    } catch (err) {
      alert('Tạo đơn hàng thất bại: ' + err.message);
    }
  };

  return (
    <div className="container">
      <h2>Giỏ hàng</h2>
      {cart.length === 0 ? (
        <div className="card">
          <p>Giỏ hàng trống. <Link to="/foods" style={{color: 'var(--primary)'}}>Chọn món ăn</Link></p>
        </div>
      ) : (
        <>
          <div>
            {cart.map((item, index) => (
              <div key={index} className="cart-item">
                <img 
                  src={`https://source.unsplash.com/80x80/?${encodeURIComponent(item.name)}`} 
                  alt={item.name}
                  onError={(e) => {
                    e.target.src = 'https://via.placeholder.com/80x80/FF6B35/FFFFFF?text=' + item.name.charAt(0);
                  }}
                />
                <div style={{flex: 1}}>
                  <strong>{item.name}</strong> x1
                  <div>{item.price.toLocaleString()} VNĐ</div>
                </div>
                <button className="btn btn-danger" onClick={() => setCart(cart.filter((_, i) => i !== index))}>
                  Xóa
                </button>
              </div>
            ))}
          </div>
          <div className="total">
            Tổng tiền: <strong>{total.toLocaleString()} VNĐ</strong>
          </div>
          <button className="btn btn-success" onClick={handleCheckout}>
            Đặt hàng
          </button>
        </>
      )}
    </div>
  );
};

export default Cart;

