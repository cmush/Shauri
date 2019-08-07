# Shauri

## Build
When building for production, remember to include the app/config/production.props file with `BASE_URL="host:port"` in your build environment.

## Known issues
- The app uses a http endpoint which necessitates dropping our guard until the matter is resolved. Hence the line `android:usesCleartextTraffic="true"` in `AndroidManifest.xml`.
- The app is unable to handle code `500` responses at the moment.
- There is zero test coverage.
- No mocking libraries have been used (may assist in debugging the inability to handle error code `500`).