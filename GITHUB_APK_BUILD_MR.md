# GitHub वरून MAX APK Build करण्याची पूर्ण प्रक्रिया (Step by Step)

## भाग A – Repository तयार करणे
1. https://github.com वर login करा.
2. वर उजवीकडे **+** → **New repository** दाबा.
3. Repository name: `MAX-Offline-Android`. Private निवडा. "Add a README" वगैरे काहीही tick करू नका. **Create repository** दाबा.

## भाग B – Files upload करणे
> **सर्वात महत्त्वाचे:** `MAX_Android_Project` हा फोल्डर स्वतः upload करू नका. त्याच्या **आतल्या** फाइल्स upload करा, म्हणजे `settings.gradle.kts`, `app` आणि `.github` हे repository च्या थेट root मध्ये दिसले पाहिजेत.

4. ZIP extract करा आणि `MAX_Android_Project` फोल्डर उघडा.
5. Repository पेजवर **uploading an existing file** लिंक दाबा.
6. फोल्डरमधील सर्व फाइल्स व फोल्डर्स (`app`, `.github`, `build.gradle.kts`, `settings.gradle.kts`, `gradle.properties`, `.gitignore` इ.) drag-and-drop करा.
7. `.github` hidden folder दिसत नसेल (Windows: View → Hidden items; Mac: `Cmd + Shift + .`).
8. `.github` drag-drop मध्ये येत नसेल तर: **Add file → Create new file** → नावात `.github/workflows/android-build.yml` टाका (`/` टाकताच folder तयार होतो) → `android-build.yml` ची संपूर्ण मजकूर paste करा.
9. खाली **Commit changes** दाबा (Branch: `main`).

## भाग C – Build चालवणे
10. वरच्या menu मध्ये **Actions** टॅब उघडा. "I understand my workflows, go ahead and enable them" दिसले तर ते दाबा.
11. डावीकडे **Build MAX APK** निवडा.
12. उजवीकडे **Run workflow** → branch `main` → पुन्हा **Run workflow**. (Commit केल्यावर तो आपोआपही सुरू होतो.)
13. चालू असलेल्या run वर क्लिक करा → **Build debug APK** job उघडा. पहिल्या वेळी 5–10 मिनिटे लागतात.
14. सर्व steps ला हिरवा ✓ आला की build यशस्वी.

## भाग D – APK download व install
15. Run च्या पेजवर खाली स्क्रोल करून **Artifacts** पाहा.
16. **MAX-debug-APK** वर क्लिक करून ZIP download करा.
17. ZIP extract करा → आत `app-debug.apk`.
18. फोनवर APK पाठवा (USB / Drive / WhatsApp-to-self).
19. फोनमध्ये Settings → "Install unknown apps" मध्ये ती APK उघडणारे app (Files/Chrome) ला परवानगी द्या.
20. APK वर टॅप करून **Install** करा. (Debug APK आहे; Play Protect warning आल्यास "Install anyway".)

## जर Failed (लाल ✗) झाले तर
- Actions → त्या run वर क्लिक → लाल ✗ असलेला step उघडा → शेवटच्या 30 ओळी copy करून पाठवा.
- त्याच run च्या Artifacts मध्ये `build-reports` दिसल्यास तेही download करा.
- Failure `Checkout`/`Build debug APK` मध्ये "gradle: command not found" किंवा "settings.gradle.kts not found" असेल तर Step 4–6 पुन्हा तपासा: files चुकून एका extra फोल्डरमध्ये गेल्या असतील.

टीप: हा starter MAX project आहे; मूळ Panda app चे सर्व features यात नाहीत.
