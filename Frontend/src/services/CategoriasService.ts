export const obtenerCategorias = async () => {
	const res = await fetch("/data/categorias.ts");
	return await res.json();
}