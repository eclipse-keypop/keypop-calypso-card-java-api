# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

## [2.2.0] - 2025-11-21
### Added
- `TransactionManager` now extends `CardTransactionManager` from Keypop Reader API.
### Fixed
- Fixed JUnit configuration.
### Changed
- Migrated the CI pipeline from Jenkins to GitHub Actions.
### Deprecated
- `ChannelControl`, 
- `TransactionManager.processCommands(ChannelControl channelControl)`, 
- `CardIOException`,
- `ReaderIOException`, 
- `UnexpectedCommandStatusException`.
### Upgraded
- Keypop Reader API `2.0.1` -> `2.1.0`

## [2.1.2] - 2025-03-20
### Added
- Added clarification that `preparePutData` is not allowed in a secure session. 

## [2.1.1] - 2025-03-18
:warning: Security Fix
### Security
- Restrict methods `prepareGetData`, `prepareReadRecord`, `prepareReadRecordsPartially` and `prepareSearchRecords` from
  being used in secure session

## [2.1.0] - 2024-04-12
### Changed
- Java source and target levels `1.6` -> `1.8`
### Upgraded
- Gradle `6.8.3` -> `7.6.4`
- Keypop Reader API `2.0.0` -> `2.0.1` (code source not impacted)
### Added
- Support for PKI cards
  - New APIs dedicated to the card personalization: 
    - added `PutDataTag` enum
    - added `preparePutData(PutDataTag tag, byte[] data)` method to `TransactionManager`
    - added `prepareGenerateAsymmetricKeyPair()` method to `TransactionManager`
    - added `CARD_PUBLIC_KEY`, `CARD_CERTIFICATE`, `CA_CERTIFICATE` entries to `GetDataTag` enum
    - added `getCardPublicKey()`, `getCardCertificate()`, `getCaCertificate()` methods to `CalypsoCard`
  - New APIs/SPIs dedicated to the card secure transaction in PKI mode:
    - added SPIs to operate the involved certificates with an external library: `PcaCertificate`, 
      `CaCertificate`, `CaCertificateParser`, `CardCertificate`, `CardCertificateParser`
    - added `AsymmetricCryptoSecuritySetting` interface
    - added `createAsymmetricCryptoSecuritySetting(...)` method to `CalypsoCardApiFactory`
    - added `SecurePkiModeTransactionManager` interface
    - added `createSecurePkiModeTransactionManager(...)` method to `CalypsoCardApiFactory`
    - added `InvalidCertificateException`

## [2.0.0] - 2023-11-27
:warning: The project has been migrated from the [Calypsonet Terminal Calypso API](https://github.com/calypsonet/calypsonet-terminal-calypso-java-api)
GitHub repository.
### Added
- `CalypsoCardApiFactory` centralizes the methods used to create instances of the various interfaces of the API.
- Exception `InvalidPinException` to be thrown if an invalid PIN is provided by the user.
- SPI `CardTransactionCryptoExtension` must be implemented by a crypto extension to extends a card transaction with
  specific crypto features (e.g. signature computation, etc.).
- SPI `SymmetricCryptoCardTransactionManagerFactory` must be implemented by a symmetric crypto extension so that it can 
  be associated with a card transaction requiring a symmetric cryptographic module to secure the transaction
  (e.g. Legacy SAM, Open SAM, etc.).
- SPI `AsymmetricCryptoCardTransactionManagerFactory` must be implemented by an asymmetric crypto extension so that it 
  can be associated with a card transaction requiring an asymmetric cryptographic module to secure the transaction
  (e.g. PKI).
- Method `SecureTransactionManager.getCryptoExtension(Class<E> cryptoExtensionClass)` returns the
  `CardTransactionCryptoExtension` associated with the secure card transaction.
### Changed
- The project license is now "MIT License" (previously "Eclipse Public License 2.0").
- CI: The Gradle plugin `org.eclipse.keyple:keyple-gradle:0.2.+` has been replaced
  by `org.eclipse.keypop:keypop-gradle:0.1.+`.
- Renamed:
  - Artifact `org.calypsonet.terminal:calypsonet-terminal-calypso-java-api` -> `org.eclipse.keypop:keypop-calypso-card-java-api`
  - Package `org.calypsonet.terminal.calypso` -> `org.eclipse.keypop.calypso.card`
  - Class `CalypsoApiProperties` -> `CalypsoCardApiProperties`
  - Class `SamIOException` -> `CryptoIOException`
  - Interface `CalypsoCardSelection` -> `CalypsoCardSelectionExtension`
  - Interface `CardSecuritySetting` -> `SymmetricCryptoSecuritySetting`
  - Method `initSamContextForNextTransaction()` -> `initCryptoContextForNextTransaction()`
- Method signature refactored:
  - `processCommands(boolean closePhysicalChannel)` -> `processCommands(ChannelControl channelControl)`. 
    The enum `ChannelControl` has been created for this purpose.
- `CalypsoCard` extends now `IsoSmartCard`.
- `CardTransactionManager` has been split into the followings interfaces:
  - `FreeTransactionManager`: Manager of card transactions requiring no cryptographic computation.
  - `SecureRegularModeTransactionManager`: Manager of card transactions secured by symmetric key cryptographic 
    algorithms, compatible with all Regular Calypso products.
  - `SecureExtendedModeTransactionManager`: Manager of card transactions secured by symmetric key cryptographic 
    algorithms, adding additional operations available only for "Calypso Prime Extended" products.
  - `SecurePkiModeTransactionManager`: Manager of card transactions secured by asymmetric key cryptographic 
    algorithms, compatible only with "Calypso Prime PKI" products.
### Removed
- All elements related to the SAM have been removed and will be provided by specific symmetric crypto extensions:
  - `CommonSecuritySetting`
  - `SamSecuritySetting`
  - `CalypsoSamSelection`
  - `CalypsoSam`
  - `SamTransactionManager`
  - `CommonSignatureComputationData`
  - `BasicSignatureComputationData`
  - `TraceableSignatureComputationData`
  - `CommonSignatureVerificationData`
  - `BasicSignatureVerificationData`
  - `TraceableSignatureVerificationData`
  - `SamRevocationServiceSpi`
  - `SamRevokedException`
  - `InvalidSignatureException`
- All deprecated and obsolete methods have been removed:
  - `CalypsoCardSelection.filterByCardProtocol(String cardProtocol)` (moved to the "Keypop Reader Java API")
  - `CalypsoCardSelection.filterByPowerOnData(String powerOnDataRegex)` (moved to the "Keypop Reader Java API")
  - `CalypsoCardSelection.filterByDfName(byte[] aid)` (moved to the "Keypop Reader Java API")
  - `CalypsoCardSelection.filterByDfName(String aid)` (moved to the "Keypop Reader Java API")
  - `CalypsoCardSelection.setFileOccurrence(FileOccurrence fileOccurrence)` (moved to the "Keypop Reader Java API")
  - `CalypsoCardSelection.setFileControlInformation(FileControlInformation fileControlInformation)` (moved to the "Keypop Reader Java API")
  - `CalypsoCardSelection.addSuccessfulStatusWord(int statusWord)`
  - `CalypsoCardSelection.prepareSelectFile(byte[] lid)`
  - `CalypsoCardSelection.prepareReadRecordFile(byte sfi, int recordNumber)`
  - `CalypsoCard.getAllFiles()`
  - `CommonTransactionManager.getSecuritySetting()`
  - `CommonTransactionManager.prepareComputeSignature(CommonSignatureComputationData<?> data)`
  - `CommonTransactionManager.prepareVerifySignature(CommonSignatureVerificationData<?> data)`
  - `CommonTransactionManager.processCommands()`
  - `CardTransactionManager.getCardReader()`
  - `CardTransactionManager.getCalypsoCard()`
  - `CardTransactionManager.getCardSecuritySetting()`
  - `CardTransactionManager.prepareSelectFile(byte[] lid)`
  - `CardTransactionManager.prepareReadRecordFile(byte sfi, int recordNumber)`
  - `CardTransactionManager.prepareReadRecordFile(byte sfi, int firstRecordNumber, int numberOfRecords, int recordSize)`
  - `CardTransactionManager.prepareReadCounterFile(byte sfi, int countersNumber)`
  - `CardTransactionManager.prepareReleaseCardChannel()`
  - `CardTransactionManager.processCardCommands()`
  - `CardTransactionManager.processVerifyPin(byte[] pin)`
  - `CardTransactionManager.processChangePin(byte[] newPin)`
  - `CardTransactionManager.processChangeKey(int keyIndex, byte newKif, byte newKvc, byte issuerKif, byte issuerKvc)`
  - `CardTransactionManager.processOpening(WriteAccessLevel writeAccessLevel)`
  - `CardTransactionManager.processClosing()`
  - `CardTransactionManager.processCancel()`
  - `CardSecuritySetting.setSamResource(CardReader samReader, CalypsoSam calypsoSam)`

## [1.8.0] - 2023-04-04
### Added
- `CardTransactionManager.initSamContextForNextTransaction` method.

## [1.7.0] - 2023-03-08
### Added
- `CalypsoCardSelection.prepareReadBinary` method.
- `CalypsoCardSelection.prepareReadCounter` method.
- `CalypsoCardSelection.preparePreOpenSecureSession` method (secure session "pre-open" variant).
### Upgraded
- "Calypsonet Terminal Reader API" to version `1.2.0`

## [1.6.0] - 2023-02-17
### Added
- `CommonTransactionManager.processCommands(boolean closePhysicalChannel)` method.
- `CardTransactionManager.prepareVerifyPin` method.
- `CardTransactionManager.prepareChangePin` method.
- `CardTransactionManager.prepareChangeKey` method.
- `CardTransactionManager.prepareOpenSecureSession` method.
- `CardTransactionManager.prepareCloseSecureSession` method.
- `CardTransactionManager.prepareCancelSecureSession` method.
- `CardSecuritySetting.disableReadOnSessionOpening` method.
### Deprecated
- `CommonTransactionManager.processCommands()` method.
- `CardTransactionManager.prepareReleaseCardChannel` method.
- `CardTransactionManager.processVerifyPin` method.
- `CardTransactionManager.processChangePin` method.
- `CardTransactionManager.processChangeKey` method.
- `CardTransactionManager.processOpening` method.
- `CardTransactionManager.processClosing` method.
- `CardTransactionManager.processCancel` method.

## [1.5.0] - 2022-12-22
### Added
- `CardTransactionManager.prepareEarlyMutualAuthentication` method (extended mode).
- `CardTransactionManager.prepareActivateEncryption` method (extended mode).
- `CardTransactionManager.prepareDeactivateEncryption` method (extended mode).
### Deprecated
- `SamSecuritySetting` API.
- `SamTransactionManager` API.
- `CommonTransactionManager.getSecuritySetting` method.
- `CardTransactionManager.getCardReader` method.
- `CardTransactionManager.getCalypsoCard` method.
- `CalypsoSam.ProductType.CSAM_F` value.

## [1.4.1] - 2022-11-17
### Changed
- Added precision in the documentation of the methods of the `CardTransactionManager` API.
- UML diagrams moved to a dedicated repository (see `README.md` file).

## [1.4.0] - 2022-10-26
### Added
- `SelectFileException` to manage the status of the "Select File" card command.
### Upgraded
- "Calypsonet Terminal Reader API" to version `1.1.0`

## [1.3.0] - 2022-10-04
### Added
- `CalypsoSam.ProductType.HSM_C1` identifier for HSM products.

## [1.2.0] - 2022-05-30
### Added
- `CalypsoCard.getTransactionCounter` method (issue [#42]).
- `SamRevocationServiceSpi` SPI (issue [#29]).
- `CommonSignatureComputationData`.
- `BasicSignatureComputationData`.
- `TraceableSignatureComputationData` API (issue [#28]).
- `CommonSignatureVerificationData`.
- `BasicSignatureVerificationData`.
- `TraceableSignatureVerificationData` API (issue [#29]).
- `CommonSecuritySetting` API.
- `CommonSecuritySetting.setControlSamResource` method as a replacement for the `setSamResource` method.
- `CommonSecuritySetting.getTransactionAuditData` method (issue [#44]).
- `CommonTransactionManager` API.
- `CommonTransactionManager.getSecuritySetting` method as a replacement for the `getCardSecuritySetting` method.
- `CommonTransactionManager.prepareComputeSignature` method (issue [#28]).
- `CommonTransactionManager.prepareVerifySignature` method (issue [#29]).
- `CommonTransactionManager.processCommands` method as a replacement for the `processCardCommands` method.
- `SamSecuritySetting` API.
- `SamTransactionManager` API.
- `ReaderIOException` exception.
- `InvalidSignatureException` exception.
### Changed
- Renaming of `AtomicTransactionException` to `SessionBufferOverflowException`.
- Renaming of `AuthenticationNotVerifiedException` to `CardSignatureNotVerifiableException`.
- Merging of `CardAnomalyException`, `SamAnomalyException` and `CardCloseSecureSessionException` to `UnexpectedCommandStatusException`.
- Merging of `DesynchronizedExchangesException` and `InconsistencyDataException` to `InconsistentDataException`.
- Merging of `SessionAuthenticationException` and `SvAuthenticationException` to `InvalidCardSignatureException`.
### Deprecated
- `CardTransactionManager.getCardSecuritySetting` method.
- `CardTransactionManager.processCardCommands` method.
- `CardSecuritySetting.setSamResource` method.
### Removed
- `CardTransactionException` abstract common exception.

## [1.1.0] - 2022-02-01
### Added
- `prepareUpdateBinary` and `prepareWriteBinary` methods to `CardTransactionManager` API (issue [#19]).
- `prepareReadBinary` method to `CardTransactionManager` API (issue [#20]).
- `prepareReadRecordsPartially` method to `CardTransactionManager` APIs (issue [#21] and [#38]).
- `prepareSearchRecords` method to `CardTransactionManager` APIs (issue [#22]).
- `prepareIncreaseCounters` and `prepareDecreaseCounters` methods to `CardTransactionManager` API (issue [#23]).
- `processChangeKey` method to `CardTransactionManager` API (issue [#24]).
- `prepareReadRecord` and `prepareReadRecords` methods as a replacement for the `prepareReadRecordFile` methods.
- `prepareReadCounter` method as a replacement for the `prepareReadCounterFile` method.
- `EF_LIST` and `TRACEABILITY_INFORMATION` keys to `GetDataTag` API (issue [#18]).
- Management of EFs with no SFI (issue [#40]).
### Changed
- Documentation of card selection methods for older cards (issue [#17]).
- Documentation of `FileHeader` methods (issue [#18]).
- Documentation of `prepareSelectFile` methods.
### Deprecated
- `prepareSelectFile` methods using a byte array for the LID argument.
- `prepareReadRecordFile` methods.
- `prepareReadCounterFile` method.

## [1.0.5] - 2021-12-17
### Changed
- Documentation of `processClosing` method (issue [#16]).

## [1.0.4] - 2021-12-17
### Changed
- Documentation of `processOpening` and `processClosing` methods (issue [#15]).

## [1.0.3] - 2021-12-15
### Changed
- Documentation of `prepareReadRecord` methods (issue [#13]).
- Signature of methods throwing `NoSuchElementException` (issue [#13]).

## [1.0.2] - 2021-11-22
### Deprecated
- `addSuccessfulStatusWord` method (issue [#11]).

## [1.0.1] - 2021-11-22
### Added
- `CHANGELOG.md` file (issue [#9]).
- CI: Forbid the publication of a version already released (issue [#7]).
### Changed
- Description of the management of invalidated cards in `CalypsoCard` (issue [#6]).

## [1.0.0] - 2021-10-06
This is the initial release.

[unreleased]: https://github.com/eclipse-keypop/keypop-calypso-card-java-api/compare/2.2.0...HEAD
[2.2.0]: https://github.com/eclipse-keypop/keypop-calypso-card-java-api/compare/2.1.2...2.2.0
[2.1.2]: https://github.com/eclipse-keypop/keypop-calypso-card-java-api/compare/2.1.1...2.1.2
[2.1.1]: https://github.com/eclipse-keypop/keypop-calypso-card-java-api/compare/2.1.0...2.1.1
[2.1.0]: https://github.com/eclipse-keypop/keypop-calypso-card-java-api/compare/2.0.0...2.1.0
[2.0.0]: https://github.com/eclipse-keypop/keypop-calypso-card-java-api/releases/tag/2.0.0
[1.8.0]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/compare/1.7.0...1.8.0
[1.7.0]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/compare/1.6.0...1.7.0
[1.6.0]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/compare/1.5.0...1.6.0
[1.5.0]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/compare/1.4.1...1.5.0
[1.4.1]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/compare/1.4.0...1.4.1
[1.4.0]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/compare/1.3.0...1.4.0
[1.3.0]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/compare/1.2.0...1.3.0
[1.2.0]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/compare/1.1.0...1.2.0
[1.1.0]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/compare/1.0.5...1.1.0
[1.0.5]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/compare/1.0.4...1.0.5
[1.0.4]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/compare/1.0.3...1.0.4
[1.0.3]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/compare/1.0.2...1.0.3
[1.0.2]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/compare/1.0.1...1.0.2
[1.0.1]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/compare/1.0.0...1.0.1
[1.0.0]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/releases/tag/1.0.0

[#44]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/issues/44
[#42]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/issues/42
[#40]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/issues/40
[#38]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/issues/38
[#29]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/issues/29
[#28]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/issues/28
[#27]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/issues/27
[#26]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/issues/26
[#25]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/issues/25
[#24]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/issues/24
[#23]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/issues/23
[#22]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/issues/22
[#21]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/issues/21
[#20]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/issues/20
[#19]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/issues/19
[#18]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/issues/18
[#17]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/issues/17
[#16]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/issues/16
[#15]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/issues/15
[#13]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/issues/13
[#11]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/issues/11
[#9]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/issues/9
[#7]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/issues/7
[#6]: https://github.com/calypsonet/calypsonet-terminal-calypso-java-api/issues/6