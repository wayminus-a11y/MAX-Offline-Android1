# GitHub वर MAX source upload करण्याची पद्धत

1. GitHub मध्ये नवीन repository तयार करा. नाव `MAX-Offline-Android` ठेवा.
2. Repository Public की Private हे ठरवा. वैयक्तिक प्रकल्पासाठी Private अधिक योग्य.
3. या ZIP मधील `MAX_Android_Project` फोल्डरच्या **आतील** सर्व फाइल्स (`.github` सह) repository च्या root मध्ये upload करा; फोल्डर स्वतः नको.
4. `.jks`, `.keystore`, passwords, API keys, personal database किंवा ग्राहकांची माहिती कधीही upload करू नका.
5. Android Studio मध्ये repository clone करून `MAX_Android_Project` उघडा.

**महत्त्वाचे:** हा सध्या starter source आहे. Panda APK मधील सर्व फीचर्सचा पूर्ण source किंवा तयार MAX clone यात नाही.

## APK build आणि download
या project मध्ये `.github/workflows/android-build.yml` दिली आहे. GitHub वर सर्व files upload करून commit केल्यावर Actions workflow आपोआप APK build करेल. `Actions` → `Build MAX APK` → latest successful run → `Artifacts` → `MAX-debug-APK` येथून APK ZIP download करा. सविस्तर सूचना `GITHUB_APK_BUILD_MR.md` मध्ये आहेत.
