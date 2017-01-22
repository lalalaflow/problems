package problems.projecteuler.util;


/**
 * ReflectionUtils.java
 * Created on Apr 30, 2012
 * Copyright 2012 mb
 * <https://somethingididnotknow.wordpress.com>
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Some utility methods that can be used for unit tests to alter internal
 * objects states by exploiting features from <tt>java.lang.reflect</tt>
 * package.
 *
 * @author mb
 */
public class ReflectionUtils {

    /**
     * Sets the value of the <tt>static</tt> field named <tt>fieldName</tt> in
     * class <tt>clazz</tt> to <tt>newValue</tt> and returns <code>true</code>
     * if the operation was successful.
     *
     * @param clazz
     *            the class whose field is to be changed
     * @param fieldName
     *            the (case-sensitive) name of the field whose content is to be
     *            changed
     * @param newValue
     *            the new value that the field should store
     * @return <code>true</code> if the new value has been set,
     *         <code>false</code> otherwise
     */
    public static boolean changeStaticField(Class<?> clazz, String fieldName,
                                            Object newValue) {
        if (clazz == null)
            return false;
        return change(clazz, null, fieldName, newValue);
    }

    private static boolean change(Class<?> clazz, Object object,
                                  String fieldName, Object newValue) {
        boolean success = false;
        try {
            Field toChange = clazz.getDeclaredField(fieldName);
            toChange.setAccessible(true);
            toChange.set(object, newValue);
            success = true;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return success;
    }

    private static Object call(Class<?> clazz, Object object,
                               String methodName, Object... args) throws IllegalArgumentException,
            InvocationTargetException {
        Method[] allMethods = clazz.getDeclaredMethods();
        for (Method m : allMethods) {
            // cycling through all methods, as we don't want users to specify
            // the list of argument types, we rely on the compiler
            if (m.getName().equals(methodName)) {
                m.setAccessible(true);
                try {
                    Object result = m.invoke(object, args);
                    return result;
                } catch (IllegalAccessException e) {
                } catch (IllegalArgumentException e) {
                }
            }
        }
        throw new IllegalArgumentException(
                String.format(
                        "No matching method has been found for method named %s and parameters %s",
                        methodName, Arrays.toString(args)));
    }

    /**
     * Invokes the method called <tt>methodName</tt> on <tt>object</tt> passing
     * the provided arguments to it, returning the result if the invocation was
     * successful, throwing an {@link IllegalArgumentException} otherwise.
     *
     * @param object
     *            the object onto which the method is to be invoked
     * @param methodName
     *            the (case-sensitive) name of the method to be called
     * @param args
     *            the arguments to be passed to the method
     * @return the value returned by the method
     * @throws IllegalArgumentException
     *             in case a method called <tt>methodName</tt> accepting the
     *             provided list of arguments is not found, or <tt>object</tt>
     *             is <code>null</code>
     * @throws InvocationTargetException
     *             in case the method threw an exception (that can be retrieved
     *             calling {@link InvocationTargetException#getCause()} on the
     *             caught exception)
     */
    public static Object callMethod(Object object, String methodName,
                                    Object... args) throws IllegalArgumentException,
            InvocationTargetException {
        if (object == null || methodName == null)
            throw new IllegalArgumentException("null object or method name");
        return call(object.getClass(), object, methodName, args);
    }

    /**
     * Invokes the method called <tt>methodName</tt> of class <tt>clazz</tt>
     * passing the provided arguments to it, returning the result if the
     * invocation was successful, throwing an {@link IllegalArgumentException}
     * otherwise.
     *
     * @param clazz
     *            the class whose method is to be invoked
     * @param methodName
     *            the (case-sensitive) name of the method to be called
     * @param args
     *            the arguments to be passed to the method
     * @return the value returned by the method
     * @throws IllegalArgumentException
     *             in case a method called <tt>methodName</tt> accepting the
     *             provided list of arguments is not found, or <tt>object</tt>
     *             is <code>null</code>
     * @throws InvocationTargetException
     *             in case the method threw an exception (that can be retrieved
     *             calling {@link InvocationTargetException#getCause()} on the
     *             caught exception)
     */
    public static Object callStaticMethod(Class<?> clazz, String methodName,
                                          Object... args) throws IllegalArgumentException,
            InvocationTargetException {
        if (clazz == null || methodName == null)
            throw new IllegalArgumentException("null class or method name");
        return call(clazz, null, methodName, args);
    }

    /**
     * Sets the value of the field named <tt>fieldName</tt> for object
     * <tt>object</tt> to <tt>newValue</tt> and returns <code>true</code> if the
     * operation was successful.
     *
     * @param object
     *            the object whose field is to be changed
     * @param fieldName
     *            the (case-sensitive) name of the field whose content is to be
     *            changed
     * @param newValue
     *            the new value that the field should store
     * @return <code>true</code> if the new value has been set,
     *         <code>false</code> otherwise
     */
    public static boolean changeField(Object object, String fieldName,
                                      Object newValue) {
        if (object == null)
            return false;
        return change(object.getClass(), object, fieldName, newValue);
    }

    /**
     * Creates a new object of type <tt>T</tt> by calling a constructor of class
     * <tt>clazz</tt> accepting the provided list of <tt>args</tt>.
     *
     * @param <T>
     *            the type of the object to be created
     * @param clazz
     *            the class of the object to be created (remember, it's
     *            <tt>Class&lt;T&gt;</tt>)
     * @param args
     *            the arguments to feed the constructor with
     * @return the created object or <code>null</code> if anything goes wrong
     * @throws InvocationTargetException
     *             in case the matching constructor throws an <tt>Exception</tt>
     *             (that can be retrieved calling
     *             {@link InvocationTargetException#getCause()} on the caught
     *             exception) when called
     */
    public static <T> T createNew(Class<T> clazz, Object... args)
            throws InvocationTargetException {
        if (clazz == null)
            return null;
        Constructor<?>[] allConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> c : allConstructors) {
            // cycling through all constructors, as we don't want users to
            // specify
            // the list of argument types, we rely on the compiler
            c.setAccessible(true);
            try {
                Object result = c.newInstance(args);
                return clazz.cast(result);
            } catch (IllegalAccessException e) {
            } catch (IllegalArgumentException e) {
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
        throw new IllegalArgumentException(
                String.format(
                        "No matching constructor has been found for class %s and parameters %s",
                        clazz, Arrays.toString(args)));
    }
}