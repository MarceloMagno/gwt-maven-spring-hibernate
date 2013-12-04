package br.com.shared.domai;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Usuario_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  private static native java.lang.String getLogin(br.com.shared.domai.Usuario instance) /*-{
    return instance.@br.com.shared.domai.Usuario::Login;
  }-*/;
  
  private static native void setLogin(br.com.shared.domai.Usuario instance, java.lang.String value) 
  /*-{
    instance.@br.com.shared.domai.Usuario::Login = value;
  }-*/;
  
  private static native java.lang.Long getId(br.com.shared.domai.Usuario instance) /*-{
    return instance.@br.com.shared.domai.Usuario::id;
  }-*/;
  
  private static native void setId(br.com.shared.domai.Usuario instance, java.lang.Long value) 
  /*-{
    instance.@br.com.shared.domai.Usuario::id = value;
  }-*/;
  
  private static native java.lang.String getNome(br.com.shared.domai.Usuario instance) /*-{
    return instance.@br.com.shared.domai.Usuario::nome;
  }-*/;
  
  private static native void setNome(br.com.shared.domai.Usuario instance, java.lang.String value) 
  /*-{
    instance.@br.com.shared.domai.Usuario::nome = value;
  }-*/;
  
  private static native java.lang.String getSenha(br.com.shared.domai.Usuario instance) /*-{
    return instance.@br.com.shared.domai.Usuario::senha;
  }-*/;
  
  private static native void setSenha(br.com.shared.domai.Usuario instance, java.lang.String value) 
  /*-{
    instance.@br.com.shared.domai.Usuario::senha = value;
  }-*/;
  
  public static void deserialize(SerializationStreamReader streamReader, br.com.shared.domai.Usuario instance) throws SerializationException {
    com.google.gwt.core.client.impl.WeakMapping.set(instance, "server-enhanced-data-1", streamReader.readString());
    setLogin(instance, streamReader.readString());
    setId(instance, (java.lang.Long) streamReader.readObject());
    setNome(instance, streamReader.readString());
    setSenha(instance, streamReader.readString());
    
  }
  
  public static br.com.shared.domai.Usuario instantiate(SerializationStreamReader streamReader) throws SerializationException {
    return new br.com.shared.domai.Usuario();
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, br.com.shared.domai.Usuario instance) throws SerializationException {
    streamWriter.writeString((String) com.google.gwt.core.client.impl.WeakMapping.get(instance, "server-enhanced-data-1"));
    streamWriter.writeString(getLogin(instance));
    streamWriter.writeObject(getId(instance));
    streamWriter.writeString(getNome(instance));
    streamWriter.writeString(getSenha(instance));
    
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return br.com.shared.domai.Usuario_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    br.com.shared.domai.Usuario_FieldSerializer.deserialize(reader, (br.com.shared.domai.Usuario)object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    br.com.shared.domai.Usuario_FieldSerializer.serialize(writer, (br.com.shared.domai.Usuario)object);
  }
  
}
