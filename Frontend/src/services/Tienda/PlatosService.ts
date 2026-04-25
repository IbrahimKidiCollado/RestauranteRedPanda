//import axios from 'axios';

export const obtenerPlatos = async (categoria?: string) => {
	const ruta = categoria 
        ? `http://localhost:8081/${categoria}` 
        : `http://localhost:8081/carta`;
	const res = await fetch(ruta);
	return await res.json();
}

export const eliminarPlato = async (id: number, categoria: string): Promise<boolean> => {
	try {
		const res = await fetch(`http://localhost:8081/${categoria}/delete/${id}`,{
			method: 'DELETE',
			headers: {
                'Content-Type': 'application/json'
            }
		});

		if(!res.ok){
			throw new Error('Error al intentar eliminar el plato de la carta')
		}
		return true
		
	} catch (error) {
		console.error("Error en el servicio de eliminar: ", error);
		return false;
		
	}

}

export const annadirPlato = async(nombre: string, descripcion: string, precio: number, cantidad: number, categoria : string, imagen  : string) =>{
	try {
		const res = await fetch(`http://localhost:8081/${categoria}/create`,{
			method: 'POST',
			headers: {
                'Content-Type': 'application/json'
            },
			body: JSON.stringify({
				nombre: nombre,
				descripcion: descripcion,
				precio: precio,
				cantidad: cantidad,
				imagen: "/assets/carta/"+ categoria + "/" + imagen,
				carta: {id: 1}
			})
		})
		
		if (!res.ok){
			throw new Error('Error al intentar añadir a la carta ')
		}
		
		return true;
	} catch (error) {
		console.error("Error en el servicio de crear: ", error);
		return false
		
	}
}

export const actualizarPlato = async(nombre: string, id: number, descripcion: string, precio: number, cantidad: number, categoria : string, imagen : string ) =>{
	try {
		const res = await fetch(`http://localhost:8081/${categoria}/update/${id}`,{
			method: 'PUT',
			headers: {
                'Content-Type': 'application/json'
            },
			body: JSON.stringify({
				nombre: nombre,
				descripcion: descripcion,
				precio: precio,
				cantidad: cantidad,
				imagen: "/assets/carta/"+ categoria + "/" + imagen

			})
		})
		
		if (!res.ok){
			throw new Error('Error al intentar actualizar plato de la carta ')
		}
		
		return true;
	} catch (error) {
		console.error("Error en el servicio de crear: ", error);
		return false
		
	}
}