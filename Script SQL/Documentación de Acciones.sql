-- DESCRIPCI�N DE ACCIONES 
--Mi�rcoles 30/07/2008 a Jueves 31/07/2008
**EMPLEADOS
Procedimientos de: Agregaci�n, Actualizaci�n, Dar de Baja a Empleado
**CARGOS
Procedimientos de: Agregaci�n, Actualizaci�n, Eliminaci�n

**DEDUCCIONES DE EMPLEADOS
Procedimiento de: Agregaci�n, Anulaci�n
Triggers: Disminuci�n de Existencias de la Tabla ProductoProveedor
	
	**DETALLE DE DEDUCCIONES
	Procedimiento de: Agregaci�n

**PLANILLA
Procedimiento de: Agregaci�n, Cancelaci�n de Planilla, Anular Planilla
	**CONTROL DE ASISTENCIA
	Procedimientos de: AgregarHEntradaCA, AgregarHSalidaCA, EliminarControlAsistencia

--Jueves 31/07/2008
**HORAS EXTRAS
Funciones: 
		
		ObtenerFIPlanilla(@CodPlanilla int)
		ObtenerFFPlanilla(@CodPlanilla int)
		ObtenerMinExtras(@CodPlanilla int, @CodEmpleado int)

		MinutosExtras(@FHEntrada datetime, @FHSalida datetime)
		MinutosTrabajados(@FHEntrada datetime, @FHSalida datetime)
		