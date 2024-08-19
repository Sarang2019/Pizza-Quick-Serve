import React from 'react';
import { Link } from 'react-router-dom';
import '../../styles/Admin.css';

function AdminDashboard() {
  return (
    <div className="dashboard">
      <h2>Admin Dashboard</h2>
      <ul>
        <li>
          <Link to="/admin/manage-orders">Manage Orders</Link>
        </li>
        <li>
          <Link to="/admin/add-pizza">Add/Remove Pizzas</Link>
        </li>
        <li>
          <Link to="/admin/view-reports">View Reports</Link>
        </li>
      </ul>
      <button className="logout-button" onClick={() => alert('Logout functionality here')}>Logout</button>
    </div>
  );
}

export default AdminDashboard;
