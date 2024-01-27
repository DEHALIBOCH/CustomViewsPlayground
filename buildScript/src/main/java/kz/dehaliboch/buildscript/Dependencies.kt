package kz.dehaliboch.buildscript

object Dependencies {

    /* Base */
    const val APPCOMPAT = "androidx.appcompat:appcompat:${DependenciesVersions.APPCOMPAT}"
    const val MATERIAL = "com.google.android.material:material${DependenciesVersions.MATERIAL}"
    const val CONSTRAINTLAYOUT = "androidx.constraintlayout:constraintlayout${DependenciesVersions.CONSTRAINTLAYOUT}"
    const val JUNIT = "junit:junit${DependenciesVersions.JUNIT}"
    const val ANDROIDX_JUNIT = "androidx.test.ext:junit${DependenciesVersions.ANDROIDX_JUNIT}"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core${DependenciesVersions.ESPRESSO_CORE}"

    /* KTX */
    const val CORE_KTX = "androidx.core:core-ktx${DependenciesVersions.CORE_KTX}"
    const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx${DependenciesVersions.FRAGMENT_KTX}"
    const val LIFECYCLE_RUNTIME_KTX = "androidx.lifecycle:lifecycle-runtime-ktx${DependenciesVersions.LIFECYCLE_RUNTIME_AND_VIEWMODEL_KTX}"
    const val PALETTE_KTX = "androidx.palette:palette-ktx${DependenciesVersions.PALETTE_KTX}"
    const val VIEWMODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx${DependenciesVersions.LIFECYCLE_RUNTIME_AND_VIEWMODEL_KTX}"

    /* Room */
    const val ROOM = "androidx.room:room-runtime${DependenciesVersions.ROOM}"
    const val ROOM_COMPILER = "androidx.room:room-compiler${DependenciesVersions.ROOM}"
    const val ROOM_PAGING = "androidx.room:room-paging${DependenciesVersions.ROOM}"
    const val ROOM_KTX = "androidx.room:room-ktx${DependenciesVersions.ROOM}"

    /* Paging 3 */
    const val PAGING_3 = "androidx.paging:paging-runtime${DependenciesVersions.PAGING_3}"

    /* Koin */
    const val KOIN_ANDROID = "io.insert-koin:koin-android${DependenciesVersions.KOIN}"

}