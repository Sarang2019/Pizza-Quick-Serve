import React, { useEffect, useState } from 'react';
import '../../styles/Admin.css';

function ViewOrders() {
  const [orders, setOrders] = useState([]);

  useEffect(() => {
    
  }, []);

  return (
    <div className="view-orders">
      <h2>View Orders</h2>
      {orders.map(order => (
        <div key={order.id} className="order-card">
          <h3>Order #{order.id}</h3>
          <p>Customer: {order.customerName}</p>
          <p>Pizzas: {order.pizzaNames.join(', ')}</p>
          <p>Quantity: {order.quantity}</p>
          <p>Order Date: {order.orderDate}</p>
        </div>
      ))}
    </div>
  );
}

export default ViewOrders;
