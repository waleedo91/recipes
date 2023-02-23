import "./App.css";
import React, { useState, useEffect } from "react";
import api from "./api/axiosconfig";

function App() {
	const [recipes, setRecipes] = useState(null);

	const fetchRecipes = async () => {
		try {
			const resp = await api.get("/api/v1/recipes");
			console.log(resp.data);
		} catch (error) {
			console.log(error);
		}
	};

	useEffect(() => {
		fetchRecipes();
	}, []);

	return (
		<div className='App'>
			<h1></h1>
		</div>
	);
}

export default App;
