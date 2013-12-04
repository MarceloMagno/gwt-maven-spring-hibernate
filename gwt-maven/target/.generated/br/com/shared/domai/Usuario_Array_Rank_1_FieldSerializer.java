package br.com.shared.domai;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.ReflectionHelper;

@SuppressWarnings("deprecation")
public class Usuario_Array_Rank_1_FieldSerializer implements com.google.gwt.user.client.rpc.impl.TypeHandler {
  public static void deserialize(SerializationStreamReader streamReader, br.com.shared.domai.Usuario[] instance) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.deserialize(streamReader, instance);
  }
  
  public static br.com.shared.domai.Usuario[] instantiate(SerializationStreamReader streamReader) throws SerializationException {
    int size = streamReader.readInt();
    return new br.com.shared.domai.Usuario[size];
  }
  
  public static void serialize(SerializationStreamWriter streamWriter, br.com.shared.domai.Usuario[] instance) throws SerializationException {
    com.google.gwt.user.client.rpc.core.java.lang.Object_Array_CustomFieldSerializer.serialize(streamWriter, instance);
  }
  
  public Object create(SerializationStreamReader reader) throws SerializationException {
    return br.com.shared.domai.Usuario_Array_Rank_1_FieldSerializer.instantiate(reader);
  }
  
  public void deserial(SerializationStreamReader reader, Object object) throws SerializationException {
    br.com.shared.domai.Usuario_Array_Rank_1_FieldSerializer.deserialize(reader, (br.com.shared.domai.Usuario[])object);
  }
  
  public void serial(SerializationStreamWriter writer, Object object) throws SerializationException {
    br.com.shared.domai.Usuario_Array_Rank_1_FieldSerializer.serialize(writer, (br.com.shared.domai.Usuario[])object);
  }
  
}
