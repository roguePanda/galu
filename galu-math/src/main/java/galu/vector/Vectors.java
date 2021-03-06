package galu.vector;

public final class Vectors
{
	private Vectors() {}
	
	public static Vector2 vec2(float x, float y)
	{
		return new Vector2(x, y);
	}
	
	public static Vector2 vec2(float value)
	{
		return new Vector2(value, value);
	}
	
	public static Vector3 vec3(float x, float y, float z)
	{
		return new Vector3(x, y, z);
	}
	
	public static Vector3 vec3(float value)
	{
		return new Vector3(value, value, value);
	}
	
	public static Vector3 vec3(Vector2 vec, float z)
	{
		return new Vector3(vec.x, vec.y, z);
	}
	
	public static Vector4 vec4(float x, float y, float z, float w)
	{
		return new Vector4(x, y, z, w);
	}
	
	public static Vector4 vec4(float value)
	{
		return new Vector4(value, value, value, value);
	}
	
	public static Vector4 vec4(Vector2 vec, float z, float w)
	{
		return new Vector4(vec.x, vec.y, z, w);
	}
	
	public static Vector4 vec4(Vector3 vec, float w)
	{
		return new Vector4(vec.x, vec.y, vec.z, w);
	}
}
