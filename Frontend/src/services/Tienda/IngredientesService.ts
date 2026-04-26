export const obtenerIngredientes = async () => {
	const ruta = `ingredientes.json`;
	const res = await fetch(ruta);
	return await res.json();
}