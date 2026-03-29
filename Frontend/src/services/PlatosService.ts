export const obtenerPlatos = async () => {
	const res = await fetch("@/data/productos.json");
	return await res.json();
}