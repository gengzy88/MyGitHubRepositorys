//#include <string.h>
//#include <jni.h>
//
//jstring Java_com_gengzy88_myjnitest_MyJniTestActivity_getNativeString(JNIEnv* env,jobject thiz){
//	return (*env)->NewStringUTF(env, "Hello jni");
//}
#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <jni.h>
#include <assert.h>

JNIEXPORT jstring JNICALL getNativeString(JNIEnv *env, jclass clazz)
{
	printf("hello in c native code./n");
	return (*env)->NewStringUTF(env, "hello world returned.");
}

#define JNIREG_CLASS "com/gengzy88/myjnitest/MyJniTestActivity"//ָ��Ҫע�����

/**
* Table of methods associated with a single class.
*/
static JNINativeMethod gMethods[] = {
	{ "getNativeString", "()Ljava/lang/String;", (void*)getNativeString },//��
};

/*
* Register several native methods for one class.
*/
static int registerNativeMethods(JNIEnv* env, const char* className,
        JNINativeMethod* gMethods, int numMethods)
{
	jclass clazz;
	clazz = (*env)->FindClass(env, className);
	if (clazz == NULL) {
		return JNI_FALSE;
	}
	if ((*env)->RegisterNatives(env, clazz, gMethods, numMethods) < 0) {
		return JNI_FALSE;
	}

	return JNI_TRUE;
}


/*
* Register native methods for all classes we know about.
*/
static int registerNatives(JNIEnv* env)
{
	if (!registerNativeMethods(env, JNIREG_CLASS, gMethods,
                                 sizeof(gMethods) / sizeof(gMethods[0])))
		return JNI_FALSE;

	return JNI_TRUE;
}

/*
* Set some test stuff up.
*
* Returns the JNI version on success, -1 on failure.
*/
JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM* vm, void* reserved)
{
	JNIEnv* env = NULL;
	jint result = -1;

	if ((*vm)->GetEnv(vm, (void**) &env, JNI_VERSION_1_4) != JNI_OK) {
		return -1;
	}
	assert(env != NULL);

	if (!registerNatives(env)) {//ע��
		return -1;
	}
	/* success -- return valid version number */
	result = JNI_VERSION_1_4;

	return result;
}
