import React from 'react';
import '../../styles/Admin.css';

function ViewReports() {
  
  const totalOrders = 45;
  const totalRevenue = 74925;  

  return (
    <div className="view-reports">
      <h2>View Reports</h2>
      <p>Total Orders: {totalOrders}</p>
      <p>Total Revenue: ₹{totalRevenue}</p>
    </div>
  );
}

export default ViewReports;
