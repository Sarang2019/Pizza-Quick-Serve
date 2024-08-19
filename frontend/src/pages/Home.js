import React from 'react';
import { useNavigate } from 'react-router-dom';
import '../styles/Home.css'; // Custom CSS for the home page

// Import images directly from the images folder
import pepperoniImg from '../assets/images/pepperoni.jpg';
import margheritaImg from '../assets/images/margherita.jpeg';
import bbqChickenImg from '../assets/images/bbq_chicken.jpeg';

// Import the custom useAuth hook
import { useAuth } from '../context/AuthContext';

function Home() {
  const { isAuthenticated } = useAuth(); // Use the custom useAuth hook to get the authentication status
  const navigate = useNavigate(); // Navigate between routes

  const handleOrderNowClick = () => {
    if (isAuthenticated) {
      navigate('/customer/pizza-list'); // Navigate to pizza menu if authenticated
    } else {
      alert('Please sign in first!'); // Prompt user to sign in if not authenticated
      navigate('/login'); // Redirect to login page
    }
  };

  return (
    <div className="home-container">
      <header className="home-header">
        <h1>Welcome to Pizza Quick Serve</h1>
        <p>Order your favorite pizza quickly and easily!</p>
        <button className="order-now-button" onClick={handleOrderNowClick}>
          Order Now
        </button>
      </header>

      <section className="featured-pizzas">
        <h2>Featured Pizzas</h2>
        <div className="pizza-grid">
          <div className="pizza-card">
            <img src={pepperoniImg} alt="Pepperoni Pizza" />
            <h3>Pepperoni</h3>
            <p>Price: ₹199</p>
          </div>
          <div className="pizza-card">
            <img src={margheritaImg} alt="Margherita Pizza" />
            <h3>Margherita</h3>
            <p>Price: ₹179</p>
          </div>
          <div className="pizza-card">
            <img src={bbqChickenImg} alt="BBQ Chicken Pizza" />
            <h3>BBQ Chicken</h3>
            <p>Price: ₹249</p>
          </div>
        </div>
      </section>
    </div>
  );
}

export default Home;
