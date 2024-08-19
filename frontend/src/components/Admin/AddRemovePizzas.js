import React, { useState } from 'react';
import '../../styles/Dashboard.css';  

function AddRemovePizzas() {
  const [pizzas, setPizzas] = useState([]);
  const [pizzaName, setPizzaName] = useState('');
  const [pizzaPrice, setPizzaPrice] = useState('');

  const handleAddPizza = () => {
    const newPizza = { id: pizzas.length + 1, name: pizzaName, price: pizzaPrice };
    setPizzas([...pizzas, newPizza]);
    setPizzaName('');
    setPizzaPrice('');
  };

  const handleRemovePizza = (pizzaId) => {
    setPizzas(pizzas.filter((pizza) => pizza.id !== pizzaId));
  };

  return (
    <div className="add-remove-pizzas">
      <h2>Add/Remove Pizzas</h2>
      <div className="add-pizza-form">
        <input
          type="text"
          placeholder="Pizza Name"
          value={pizzaName}
          onChange={(e) => setPizzaName(e.target.value)}
        />
        <input
          type="text"
          placeholder="Pizza Price"
          value={pizzaPrice}
          onChange={(e) => setPizzaPrice(e.target.value)}
        />
        <button onClick={handleAddPizza}>Add Pizza</button>
      </div>
      <ul className="pizza-list">
        {pizzas.map((pizza) => (
          <li key={pizza.id}>
            {pizza.name} - ₹{pizza.price} 
            <button onClick={() => handleRemovePizza(pizza.id)}>Remove</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default AddRemovePizzas;
