import cx_Freeze
executables = [cx_Freeze.Executable("plataforma.py", base="Win32GUI")]

cx_Freeze.setup(
    name="Plataforma",
    options={
        "build_exe": {"packages": ["pygame"],
                      "include_files": [("./images", "./images")]}},
    executables=executables
)