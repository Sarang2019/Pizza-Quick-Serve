import React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import '../../styles/Customer.css';

function CustomerDashboard() {
  const navigate = useNavigate();

  const handleLogout = () => {
  
    alert('Logout successful');
    navigate('/login');
  };

  return (
    <div className="customer-dashboard">
      <div className="dashboard-header">
        <h2>Welcome, Customer</h2>
        <button className="logout-button" onClick={handleLogout}>Logout</button>
      </div>
      <div className="dashboard-cards">
        <div className="dashboard-card">
          <Link to="/customer/pizza-list" className="dashboard-link">View Pizza Menu</Link>
        </div>
        <div className="dashboard-card">
          <Link to="/customer/cart" className="dashboard-link">View Cart</Link>
        </div>
        <div className="dashboard-card">
          <Link to="/customer/orders" className="dashboard-link">View Your Orders</Link>
        </div>
      </div>
    </div>
  );
}

export default CustomerDashboard;
