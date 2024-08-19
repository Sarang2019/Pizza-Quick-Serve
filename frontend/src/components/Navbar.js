import React, { useState } from "react";
import { Link } from "react-router-dom";
import { useAuth } from "../context/AuthContext";
import "../styles/Navbar.css";

function Navbar() {
  const { user, logout } = useAuth();
  const [showLogout, setShowLogout] = useState(false);

  const handleLogout = () => {
    logout();
    setShowLogout(false);
  };

  return (
    <nav className="navbar">
      <div className="navbar-brand">Pizza Quick Serve</div>
      <ul className="navbar-links">
        <li>
          <Link to="/">Home</Link>
        </li>
        <li>
          <Link to="/customer/pizza-list">Menu</Link>
        </li>
        <li>
          <Link to="/customer/cart">Cart</Link>
        </li>
        {!user ? (
          <li>
            <Link to="/login">Login</Link>
          </li>
        ) : (
          <li onClick={() => setShowLogout(!showLogout)}>{user}</li>
        )}
      </ul>
      {showLogout && (
        <button className="logout-button" onClick={handleLogout}>
          Logout
        </button>
      )}
    </nav>
  );
}

export default Navbar;
