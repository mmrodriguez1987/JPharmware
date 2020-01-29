-- DESCRIPCIÓN DE ACCIONES 
--Miércoles 30/07/2008 a Jueves 31/07/2008
**EMPLEADOS
Procedimientos de: Agregación, Actualización, Dar de Baja a Empleado
**CARGOS
Procedimientos de: Agregación, Actualización, Eliminación

**DEDUCCIONES DE EMPLEADOS
Procedimiento de: Agregación, Anulación
Triggers: Disminución de Existencias de la Tabla ProductoProveedor
	
	**DETALLE DE DEDUCCIONES
	Procedimiento de: Agregación

**PLANILLA
Procedimiento de: Agregación, Cancelación de Planilla, Anular Planilla
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
		