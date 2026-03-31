export const obtenerCategorias = async () => {
	const res = await fetch("/data/categorias.json");
	return await res.json();
}