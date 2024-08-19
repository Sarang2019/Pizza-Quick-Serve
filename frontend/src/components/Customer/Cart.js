import React, { useContext } from 'react';
import { CartContext } from '../../context/CartContext';
import '../../styles/Customer.css';

function Cart() {
  const { cart } = useContext(CartContext);

  const calculateTotalPrice = () => {
    return cart.reduce((total, pizza) => total + pizza.price * pizza.quantity, 0);
  };

  return (
    <div className="cart">
      <h2>Your Cart</h2>
      {cart.length === 0 ? (
        <p>Your cart is empty.</p>
      ) : (
        <>
          <ul>
            {cart.map((pizza, index) => (
              <li key={index}>
                <img src={pizza.image} alt={pizza.name} className="pizza-image" />
                <h3>{pizza.name}</h3>
                <p>Price: ₹{pizza.price}</p>
                <p>Quantity: {pizza.quantity}</p>
                <p>Total: ₹{pizza.price * pizza.quantity}</p>
              </li>
            ))}
          </ul>
          <h3>Total Price: ₹{calculateTotalPrice()}</h3>
          <button className="checkout-button">Checkout</button>
        </>
      )}
    </div>
  );
}

export default Cart;
