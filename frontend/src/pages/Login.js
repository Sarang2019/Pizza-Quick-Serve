import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';  // Import useNavigate hook
import '../styles/Login.css';

function Login() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();  // Initialize navigate

  const handleLogin = () => {
    // Simple login logic for demonstration
    if (username === 'admin' && password === 'admin123') {
      alert('Admin Login Successful');
      navigate('/admin/dashboard');  // Redirect to admin dashboard
    } else if (username === 'customer' && password === 'customer123') {
      alert('Customer Login Successful');
      navigate('/customer/dashboard');  // Redirect to customer dashboard
    } else if (localStorage.getItem(username) && localStorage.getItem(username) === password) {
      alert('Customer Login Successful');
      navigate('/customer/dashboard');  // Redirect to customer dashboard
    } else {
      alert('Invalid credentials');
    }
  };

  const handleSignUp = () => {
    navigate('/signup');  // Navigate to sign-up page
  };

  return (
    <div className="login-container">
      <div className="login-box">
        <h2>Login</h2>
        <input
          type="text"
          placeholder="Username"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
        />
        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
        <button onClick={handleLogin}>Login</button>
        <button onClick={handleSignUp} className="signup-button">Sign Up</button> {/* Sign Up button */}
      </div>
    </div>
  );
}

export default Login;