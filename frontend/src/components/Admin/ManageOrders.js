import React, { useState } from 'react';
import '../../styles/Admin.css';

function ManageOrders() {
  const [orders, setOrders] = useState([
    { id: 1, customer: 'Ram Kumar', pizza: 'Pepperoni', quantity: 2, status: 'Pending' },
    { id: 2, customer: 'Akash Mehta', pizza: 'Margherita', quantity: 1, status: 'Delivered' },
    { id: 3, customer: 'Sachin Desai', pizza: 'BBQ Chicken', quantity: 3, status: 'In Progress' }
  ]);

  const updateOrderStatus = (id, newStatus) => {
    setOrders(orders.map(order => order.id === id ? { ...order, status: newStatus } : order));
  };

  const deleteOrder = (id) => {
    setOrders(orders.filter(order => order.id !== id));
  };

  return (
    <div className="manage-orders">
      <h2>Manage Orders</h2>
      <ul>
        {orders.map(order => (
          <li key={order.id} className="order-item">
            <h3>Order #{order.id}</h3>
            <p>Customer: {order.customer}</p>
            <p>Pizza: {order.pizza}</p>
            <p>Quantity: {order.quantity}</p>
            <p>Status: {order.status}</p>
            <button onClick={() => updateOrderStatus(order.id, 'Delivered')}>Mark as Delivered</button>
            <button onClick={() => deleteOrder(order.id)}>Delete Order</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default ManageOrders;
