export const obtenerIngredientes = async (Id: number, categoria: string) => {
	try {		
		const response = await fetch(`http://localhost:8081/${categoria}/ingredientes/${Id}`);
		if (!response.ok) {
			throw new Error(`Error al obtener los ingredientes: ${response.statusText}`);
		}
		const data = await response.json();
		return data;
	} catch (error) {
		console.error(error);
		return [];
	}
}
export const obtenerTodosIngredientes = async () => {
	try {		
		const response = await fetch(`http://localhost:8081/ingrediente`);
		if (!response.ok) {
			throw new Error(`Error al obtener los ingredientes: ${response.statusText}`);
		}
		const data = await response.json();
		return data;
	} catch (error) {
		console.error(error);
		return [];
	}
}

export const annadirIngredientes = async () => {
	try {		
		const response = await fetch(`http://localhost:8081/ingredientecreate`);
		if (!response.ok) {
			throw new Error(`Error al obtener los ingredientes: ${response.statusText}`);
		}
		const data = await response.json();
		return data;
	} catch (error) {
		console.error(error);
		return [];
	}
}