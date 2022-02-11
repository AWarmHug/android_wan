package com.bingo.android_wan.robust

import android.content.Context
import android.os.Environment
import com.meituan.robust.Patch
import com.meituan.robust.PatchManipulate
import java.io.*

class PatchManipulateImp : PatchManipulate() {

    override fun fetchPatchList(context: Context): MutableList<Patch> {
        ///storage/emulated/0/Android/data/com.bingo.android_wan/files/Documents/robust
        val patchDir=File(context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS),"robust")
        val patch=Patch()
        patch.name="patch0"
        patch.localPath="${patchDir.path}${File.separator}patch${File.separator}patch.dex"
        patch.patchesInfoImplClassFullName="com.bingo.android_wan.robust.PatchesInfoImpl"
        val patchList= mutableListOf<Patch>()

        patchList.add(patch)
        return patchList

    }

    override fun verifyPatch(context: Context, patch: Patch): Boolean {
        val cachePath =
            context.cacheDir.toString() + File.separator + "robust" + File.separator + patch.name
        patch.tempPath = cachePath
        try {
            this.copy(patch.localPath, patch.tempPath)
        } catch (var5: Exception) {
            var5.printStackTrace()
            throw RuntimeException("copy source patch to local patch error, no patch execute in path " + patch.tempPath)
        }


        return true
    }

    @Throws(IOException::class)
    fun copy(srcPath: String, dstPath: String?) {
        var srcPath = srcPath
        val index = srcPath.lastIndexOf(".jar")
        if (index > 0) {
            srcPath = srcPath.substring(0, index)
        }
        val src = File(srcPath)
        if (!src.exists()) {
            throw java.lang.RuntimeException("source patch does not exist ")
        } else {
            val dst = File(dstPath)
            if (!dst.parentFile.exists()) {
                dst.parentFile.mkdirs()
            }
            var `in`: InputStream? = null
            var out: FileOutputStream? = null
            try {
                `in` = FileInputStream(src)
                out = FileOutputStream(dst)
                val buf = ByteArray(1024)
                var len: Int
                while (`in`.read(buf).also { len = it } > 0) {
                    out.write(buf, 0, len)
                }
            } catch (var22: java.lang.Exception) {
//                Utils.reportException(var22, this.mPatchInfo)
            } finally {
                try {
                    `in`?.close()
                } catch (var21: java.lang.Exception) {
                    var21.printStackTrace()
                }
                try {
                    out?.close()
                } catch (var20: java.lang.Exception) {
                    var20.printStackTrace()
                }
            }
        }
    }


    override fun ensurePatchExist(patch: Patch): Boolean {

        return  true
    }
}