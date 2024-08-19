import React from 'react';
import { useNavigate } from 'react-router-dom';
import '../../styles/Customer.css';

function OrderDetails() {
  const navigate = useNavigate();

  const orders = [
    { id: 1, date: '2024-08-17', items: ['Pepperoni', 'Margherita'], total: 578 },
    { id: 2, date: '2024-08-16', items: ['BBQ Chicken'], total: 249 },
  ];

  return (
    <div className="order-details">
      <h2>Your Orders</h2>
      <ul>
        {orders.map(order => (
          <li key={order.id}>
            <h3>Order #{order.id}</h3>
            <p>Date: {order.date}</p>
            <p>Items: {order.items.join(', ')}</p>
            <p>Total: ₹{order.total}</p>
          </li>
        ))}
      </ul>
      <button className="back-button" onClick={() => navigate(-1)}>Go Back</button>
    </div>
  );
}

export default OrderDetails;
