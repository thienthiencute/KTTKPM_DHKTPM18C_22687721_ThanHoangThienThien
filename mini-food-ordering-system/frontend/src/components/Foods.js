import React, { useState, useEffect } from 'react';
import axios from 'axios';

const FoodsList = ({ addToCart }) => {
  const [foods, setFoods] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');

  useEffect(() => {
    axios.get('http://localhost:8082/api/foods')
      .then(response => {
        setFoods(response.data);
        setLoading(false);
      })
      .catch(err => {
        setError('Failed to load foods');
        setLoading(false);
      });
  }, []);

  if (loading) return <div className="loading container"><h3>Đang tải món ăn...</h3></div>;
  if (error) return <div className="error container"><p>{error}</p></div>;

  return (
    <div className="container">
      <h2>Danh sách món ăn</h2>
      <div className="food-list">
        {foods.map(food => (
          <div key={food.id} className="card">
            <img 
              className="food-img" 
              src={`https://source.unsplash.com/300x200/?${encodeURIComponent(food.name)}`} 
              alt={food.name}
              onError={(e) => {
                e.target.src = 'https://via.placeholder.com/300x200/FF6B35/FFFFFF?text=' + encodeURIComponent(food.name);
              }}
            />
            <h3>{food.name}</h3>
            <p>{food.description}</p>
            <p className="price">Giá: {food.price.toLocaleString()} VNĐ</p>
            <button className="btn btn-primary" onClick={() => addToCart(food)}>
              Thêm vào giỏ hàng
            </button>
          </div>
        ))}
      </div>
    </div>
  );
};

export default FoodsList;

