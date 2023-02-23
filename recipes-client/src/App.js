import "./App.css";
import React, { useState, useEffect } from "react";
import api from "./api/axiosconfig";
import { Card } from "react-bootstrap";

function App() {
	const [recipes, setRecipes] = useState([]);

	const fetchRecipes = async () => {
		try {
			const resp = await api.get("/api/v1/recipes");
			setRecipes(resp.data);
		} catch (error) {
			console.log(error);
		}
	};

	useEffect(() => {
		fetchRecipes();
	}, []);

	console.log(recipes[1]);

	return (
		<div className='App'>
			{recipes.map((recipe, i) => (
				<Card key={i} style={{ width: "18rem" }}>
					<Card.Img variant='top' src={recipe.recipeImage} />
					<Card.Body>
						<Card.Title>{recipe.recipeName}</Card.Title>
						<Card.Text>
							Some quick example text to build on the card title and make up the
							bulk of the card's content.
						</Card.Text>
						<Card.Text>Cook Time: {recipe.cookTime}</Card.Text>
						<Card.Text>Prep Time: {recipe.prepTime}</Card.Text>
						<Card.Text>Ingredients:</Card.Text>
						{recipe.ingredients.map((ing, index) => (
							<span key={index}>{(index ? ", " : "") + ing}</span>
						))}
					</Card.Body>
				</Card>
			))}
		</div>
	);
}

export default App;
