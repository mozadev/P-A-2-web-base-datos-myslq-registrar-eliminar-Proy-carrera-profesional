
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="BEAN.CarreraBean"%>
<%!ArrayList<CarreraBean> listacarrera; %>
<%listacarrera=(ArrayList<CarreraBean>)request.getAttribute("listacarrera");%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
        <script>
           
      function grabar(){
            document.form.action="<%=request.getContextPath()%>/CarreraServlet";
            document.form.method="GET";
            document.form.op.value="4";
            document.form.submit();
        }
            
        function salir(){
            document.form.action="<%=request.getContextPath()%>/CarreraServlet";
            document.form.method="GET";
            document.form.op.value="2";
            document.form.submit();
        }
        function nuevo(){
            document.form.action="<%=request.getContextPath()%>/CarreraServlet";
            document.form.method="GET";
            document.form.op.value="3";
            document.form.submit();
        }
        function modificar(cod,nomb,estado){
            document.form.action="<%=request.getContextPath()%>/CarreraServlet";
            document.form.method="GET";
            document.form.op.value="6";
            document.form.COD.value=cod;
            document.form.NOM.value=nomb;
            document.form.ESTADO.value=estado;
            document.form.submit();
        }
        function eliminar(cod){
            document.form.action="<%=request.getContextPath()%>/CarreraServlet";
            document.form.method="GET";
            document.form.op.value="8";
            document.form.COD.value=cod;
            document.form.submit();
        }
        </script>
    </head>
    
    <body>
    <center>
        <form name="form">
            <input type="hidden" name="op">
            <input type="hidden" name="COD">
            <input type="hidden" name="NOM">
             <input type="hidden" name="ESTADO">
           
                
                <center>
                <table>
                    <tr>
                        <td colspan="2">Registrar Tabla Carrera</td>
                    </tr>
                    <tr>
                        <td>Codigo: </td>
                        <td><input type="text" name="txtcodigo"></td>
                    </tr>
                    <tr>
                        <td>Nombre: </td>
                        <td><input type="text" name="txtnombre"></td>
                    </tr>
                    
                    <tr>
                        <td>Estado: </td>
                        <td><input type="text" name="txtestado"></td>
                    </tr>
                </table>
                 <table border="1">
                    <tr>
                        <td><button onclick="grabar()">Grabar</button></td>
                        
                    </tr>
                </table>
                 <font style="color: red">
                    <%
                        if(request.getAttribute("mensaje")!=null){
                            String msj=(String)request.getAttribute("mensaje");
                            out.print(msj);
                        }
                    %>
                </font>
               <table border="1">      
                <tr>
                   
                    <td colspan="3"></td>
                    <td><button onclick="salir()">Salir</button></td>
                </tr>
                <tr>
                    <td>Codigo</td>
                    <td>Nombre</td>
                     <td>Estado</td>
                     <td>Modificar</td> 
                    <td>Eliminar</td>
                    
                </tr>
                <% for(CarreraBean obj:listacarrera)
                {%>
                <tr>
                    <td><%=obj.getCODCARRERA()%></td>
                    <td><%=obj.getNOMBCARRERA()%></td>
                    <td><%=obj.getESTADOCARRERA()%></td>
                    <td><button onclick="modificar('<%=obj.getCODCARRERA()%>','<%=obj.getNOMBCARRERA()%>','<%=obj.getESTADOCARRERA()%>')">Modificar</button></td>

                    <td><button onclick="eliminar('<%=obj.getCODCARRERA()%>')">Eliminar</button></td>
                </tr>
                <%}%>
            </table>
        </form>
    </center>
    </body>
</html>
