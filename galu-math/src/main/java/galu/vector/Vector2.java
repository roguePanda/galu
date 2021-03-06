package galu.vector;

import java.nio.FloatBuffer;

import com.google.common.hash.Hashing;

import static com.google.common.base.Preconditions.checkArgument;

public final class Vector2 implements Vector<Vector2>
{
	public final float x;
	public final float y;
	
	public Vector2(final float x, final float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int size()
	{
		return 2;
	}
	
	public float get(int idx)
	{
		switch(idx)
		{
			case 0:
				return x;
			case 1:
				return y;
			default:
				throw new IndexOutOfBoundsException("Index " + idx + " exceeds bounds of Vector2");
		}
	}

	public float length()
	{
		return (float) Math.sqrt(x*x +  y*y);
	}
	
	public float lengthSquared()
	{
		return x*x + y*y;
	}
	
	public Vector2 add(Vector2 other)
	{
		return new Vector2(x + other.x, y + other.y);
	}
	
	public Vector2 subtract(Vector2 other)
	{
		return new Vector2(x - other.x, y - other.y);
	}

	public Vector2 normalize()
	{
		float magnitude = length();
		return new Vector2(x / magnitude, y / magnitude);
	}

	public float dot(Vector2 other)
	{
		return x * other.x + y * other.y;
	}
	
	public float angleBetween(Vector2 other)
	{
		// inverse cosine of dot product divided by the product of the magnitudes
		return (float) Math.acos(dot(other) / length() / other.length());
	}
	
	public Vector2 negate()
	{
		return new Vector2(-x, -y);
	}
	
	public Vector2 multiply(float factor)
	{
		return new Vector2(x * factor, y * factor);
	}
	
	public Vector2 multiply(Vector2 other)
	{
		return new Vector2(x * other.x, y * other.y);
	}
	
	public void store(FloatBuffer buffer)
	{
		checkArgument(buffer.remaining() >= 2, "Buffer has fewer than 2 elements remaining (%s)", buffer);
		buffer.put(x).put(y);
	}
	
	public void store(float[] array)
	{
		checkArgument(array.length >= 2, "Array has fewer than 2 elements (%d)", array.length);
		array[0] = x;
		array[1] = y;
	}
	
	public float[] toArray()
	{
		return new float[] {x, y};
	}
	
	public static Vector2 load(FloatBuffer buffer)
	{
		checkArgument(buffer.remaining() >= 2, "Buffer has fewer than 2 elements remaining (%s)", buffer);
		return new Vector2(buffer.get(), buffer.get());
	}
	
	public static Vector2 load(float[] array)
	{
		checkArgument(array.length >= 2, "Array has fewer than 2 elements (%d)", array.length);
		return new Vector2(array[0], array[1]);
	}
	
	@Override
	public String toString()
	{
		return String.format("(%.4f, %.4f)", x, y);
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj == null) return false;
		if(obj == this) return true;
		
		if(!(obj instanceof Vector2)) return false;
		
		Vector2 other = (Vector2) obj;
		
		return Float.floatToIntBits(x) == Float.floatToIntBits(other.x) &&
				Float.floatToIntBits(y) == Float.floatToIntBits(other.y);
	}
	
	@Override
	public int hashCode()
	{
		int result = 31;
		result = 37 * result + Float.floatToIntBits(x);
		result = 37 * result + Float.floatToIntBits(y);
		return result;
	}
}
