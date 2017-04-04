require u-boot-rpi.inc
PROVIDES = ""

# This revision corresponds to the tag "v2017.01"
# We use the revision in order to avoid having to fetch it from the
# repo during parse
SRCREV = "a705ebc81b7f91bbd0ef7c634284208342901149"

# We are only interested in the u-boot binary. Override all else and deploy
# only that.
do_install[noexec] = "1"
do_populate_sysroot[noexec] = "1"
do_package_qa[noexec] = "1"
do_package_write_deb[noexec] = "1"
do_perform_packagecopy[noexec] = "1"

UBOOT_MACHINE="rpi_3_32b_config"

do_deploy () {
    install -d ${DEPLOYDIR}/boot
    install ${S}/${UBOOT_BINARY} ${DEPLOYDIR}/u-boot-rpi3.bin
    ln -sf ../u-boot-rpi3.bin ${DEPLOYDIR}/boot/u-boot-rpi3.bin
}
do_deploy[dirs] += "${DEPLOYDIR}/boot"
