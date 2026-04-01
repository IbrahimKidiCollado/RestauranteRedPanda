export const obtenerPlatos = async () => {
	const res = await fetch("http://localhost:8081/carta");
	return await res.json();
}