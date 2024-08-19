import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import '../styles/Signup.css';

function Signup() {
  const [username, setUsername] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState(null);
  const navigate = useNavigate();

  const handleSignUp = async () => {
    if (username && email && password) {
      try {
        const response = await fetch('http://localhost:8080/auth/register', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify({
            name: username,
            email: email,
            password: password,
          }),
        });

        if (response.ok) {
          alert('Sign Up Successful! You can now log in with your credentials.');
          navigate('/login');  // Redirect to login page
        } else {
          const errorMessage = await response.text();
          setError(`Sign Up Failed: ${errorMessage}`);
        }
      } catch (error) {
        setError('Sign Up Failed: Could not reach the server');
      }
    } else {
      setError('Please fill out all fields');
    }
  };

  return (
    <div className="signup-container">
      <div className="signup-box">
        <h2>Sign Up</h2>
        <input
          type="text"
          placeholder="Username"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
        />
        <input
          type="email"
          placeholder="Email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />
        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
        <button onClick={handleSignUp}>Sign Up</button>
        {error && <p className="error-message">{error}</p>}
      </div>
    </div>
  );
}

export default Signup;
