import React, { useContext, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { CartContext } from '../../context/CartContext';
import '../../styles/PizzaMenu.css';


import pepperoniImg from '../../assets/images/pepperoni.jpg';
import margheritaImg from '../../assets/images/margherita.jpeg';
import bbqChickenImg from '../../assets/images/bbq_chicken.jpeg';
import veggieDelightImg from '../../assets/images/veggie_delight.jpg';
import fourCheeseImg from '../../assets/images/four_cheese.jpg';

function PizzaList() {
  const { addToCart } = useContext(CartContext);
  const [quantity, setQuantity] = useState({});
  const navigate = useNavigate();

  const pizzas = [
    { id: 1, name: 'Pepperoni', price: 199, image: pepperoniImg },
    { id: 2, name: 'Margherita', price: 179, image: margheritaImg },
    { id: 3, name: 'BBQ Chicken', price: 249, image: bbqChickenImg },
    { id: 4, name: 'Veggie Delight', price: 219, image: veggieDelightImg },
    { id: 5, name: 'Four Cheese', price: 259, image: fourCheeseImg },
  ];

  const handleQuantityChange = (pizzaId, event) => {
    setQuantity({ ...quantity, [pizzaId]: parseInt(event.target.value) });
  };

  const handleAddToCart = (pizza) => {
    const pizzaQuantity = quantity[pizza.id] || 1;  // Default to 1 if no quantity is selected
    addToCart({ ...pizza, quantity: pizzaQuantity });
    alert(`${pizza.name} added to the cart with quantity ${pizzaQuantity}!`);
  };

  const handleGoBack = () => {
    navigate(-1);
  };

  const handleCheckout = () => {
    navigate('/customer/cart');
  };

  return (
    <div className="pizza-menu">
      <h2>Pizza Menu</h2>
      <div className="pizza-grid">
        {pizzas.map(pizza => (
          <div key={pizza.id} className="pizza-card">
            <img src={pizza.image} alt={pizza.name} className="pizza-image" />
            <div className="pizza-info">
              <h3>{pizza.name}</h3>
              <p>Price: ₹{pizza.price}</p>
              <div className="quantity-wrapper">
                <input
                  type="number"
                  min="1"
                  value={quantity[pizza.id] || 1}
                  onChange={(event) => handleQuantityChange(pizza.id, event)}
                  className="quantity-selector"
                />
                <button onClick={() => handleAddToCart(pizza)}>Add to Cart</button>
              </div>
            </div>
          </div>
        ))}
      </div>
      <div className="button-group">
        <button className="back-button" onClick={handleGoBack}>Go Back</button>
        <button className="checkout-button" onClick={handleCheckout}>Proceed to Checkout</button>
      </div>
    </div>
  );
}

export default PizzaList;
