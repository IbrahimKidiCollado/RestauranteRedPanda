export const annadirPedido = async (idUsuario: number, total: number, productos: any[]) => {
    try {
        const res = await fetch(`http://localhost:8081/pedido/create`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                precio: total.toString(), 
                usuario: { id: idUsuario },
                lineasPedido: productos.map(p => ({
                    cantidad: p.cantidad,
                    precio: p.precio,
                    nombrePlato: p.nombre, 
                    categoriaPlato: p.categoria_slug, 
                    ingredientesQuitados: p.listaIngredientesQuitados ,
                    ingredientesIDs: p.listaIngredientesQuitadosIDs
                }))
            }),
            credentials: 'include'
        });
        
        if (!res.ok) {
            const errorData = await res.json();
            throw new Error(errorData.message || 'Error al crear el pedido');
        }

        return await res.json();
    } catch (error) {
        console.error('Error al realizar el pedido:', error);
        throw error;
    }
}

export const obtenerPedidos = async(){

};
