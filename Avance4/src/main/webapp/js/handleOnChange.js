const handleOnChange = () => {
    const estadosSelect = document.getElementById('estado');
    let municipiosSelect = document.getElementById('registro_ciudad');
    municipiosSelect.innerHTML = '';
    let municipios = [];
    municipios = cambioCiudades(estadosSelect.value);
    municipios.forEach((municipio) => {
        let municipioOption = document.createElement("option");
        municipioOption.value = municipio;
        municipioOption.innerHTML = municipio;
        municipiosSelect.options.add(municipioOption);

    });
};


const cambioCiudades = (estado) => {
    let municipios = [];
    switch (estado) {
        case 'Sonora':
            municipios = ['Obregon', 'Hermosillo', 'Guaymas', 'Nogales', 'Navojoa'];
            break;
        case 'Chihuahua':
            municipios = ['Ciudad Cuauhtémoc', 'Guerrero', 'Chihuahua', 'Camargo'];
            break;
        case 'Sinaloa':
            municipios = ['Los Mochis', 'Guamuchil', 'Culiacán'];
            break;
        case 'Baja California':
            municipios = ['Tijuana', 'Mexicali', 'Ensenada', 'San Felipe'];
            break;
        default:
            municipios = ['Ciudad Obregón', 'Hermosillo', 'Guaymas', 'Nogales', 'Navojoa'];
    }
    return municipios;
};



